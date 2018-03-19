package edu.uav;

import java.util.ArrayList;


public class RecordService {
    /**
     * 记录列表
     */
    ArrayList<Record> recordList = new ArrayList<>();

    /**
     * 添加新的记录
     */
    public void addRecord(Record record) {
        int length = recordList.size();
        record.setNo(length);
        if (length == 0) {
            record.setCurrentCoordinate(record.getFrontCoordinate());
        } else {
            //判断前一坐标是够有效
            Record frontRecord = recordList.get(length - 1);
            if (frontRecord.isCorrect() && record.getFloatCoordinate() != null) {
                if (frontRecord.getCurrentCoordinate().equals(record.getFrontCoordinate())) {
                    int x = record.getFrontCoordinate().getX() + record.getFloatCoordinate().getX();
                    int y = record.getFrontCoordinate().getY() + record.getFloatCoordinate().getY();
                    int z = record.getFrontCoordinate().getZ() + record.getFloatCoordinate().getZ();
                    record.setCurrentCoordinate(new Coordinate(x, y, z));
                    recordList.add(record);
                    return;
                }
            }

            record.setCorrect(false);
        }

        recordList.add(record);

    }

    /**
     * 无人机是否正常运行
     *
     * @return
     */
    public boolean isCorrect() {
        if (recordList == null) {
            return false;
        }
        if (!recordList.get(recordList.size() - 1).isCorrect()) {
            return false;
        }
        return true;
    }


    /**
     * 根据消息创建一条记录
     *
     * @param message
     * @return 生成的record
     */

    public Record createRecord(String message) {
        String[] array = message.split(" ");
        int index = 0;
        Record record = new Record();
        String name = array[index++];

        //判断消息的合法性
        if (!name.matches("\\w+")) {
            record.setCorrect(false);
            return record;
        }
        record.setName(name);
        for (int i = 1; i < array.length; i++) {
            if (!array[i].matches("\\d+")) {
                record.setCorrect(false);
                return record;
            }
        }

        //生成消息
        if (array.length >= index + 3) {
            int x = Integer.valueOf(array[index++]);
            int y = Integer.valueOf(array[index++]);
            int z = Integer.valueOf(array[index++]);
            record.setFrontCoordinate(new Coordinate(x, y, z));
            record.setCorrect(true);

        } else {
            record.setCorrect(false);
            return record;
        }
        if (array.length == index + 3) {
            int x = Integer.valueOf(array[index++]);
            int y = Integer.valueOf(array[index++]);
            int z = Integer.valueOf(array[index++]);
            record.setFloatCoordinate(new Coordinate(x, y, z));
            record.setCorrect(true);
        } else if (array.length == index) {
        } else {
            record.setCorrect(false);
        }
        return record;
    }

    /**
     * 获取角标下的信息
     *
     * @param index
     * @return 信息串
     */
    public String getIndex(int index) {
        if (index >= recordList.size()) {
            return "Cannot find " + index;
        }

        Record record = recordList.get(index);
        if (record.isCorrect()) {
            return record.getName() + " " + record.getNo() + " " + record.getCurrentCoordinate().toString();
        }
        return "Error: " + record.getNo();
    }
}
