package edu.uav;

/**
 * 坐标类，已重写equals
 *
 */

public class Record {
    /**
     * 消息
     */
    private String name;
    /**
     * 前置坐标
     */
    private Coordinate frontCoordinate;
    /**
     * 浮动向量
     */
    private Coordinate floatCoordinate;
    /**
     * 当前坐标
     */
    private Coordinate currentCoordinate;
    /**
     * 状态 默认false
     */
    private boolean correct = false;

    /**
     * 编号
     */
    private int no;

    public Record() {
        super();
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinate getFrontCoordinate() {
        return frontCoordinate;
    }

    public void setFrontCoordinate(Coordinate frontCoordinate) {
        this.frontCoordinate = frontCoordinate;
    }

    public Coordinate getFloatCoordinate() {
        return floatCoordinate;
    }

    public void setFloatCoordinate(Coordinate floatCoordinate) {
        this.floatCoordinate = floatCoordinate;
    }

    public Coordinate getCurrentCoordinate() {
        return currentCoordinate;
    }

    public void setCurrentCoordinate(Coordinate currentCoordinate) {
        this.currentCoordinate = currentCoordinate;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

}
