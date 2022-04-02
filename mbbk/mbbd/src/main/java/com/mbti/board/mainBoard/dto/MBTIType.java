package com.mbti.board.mainBoard.dto;

public enum MBTIType {
    ISTJ(1), ISTP(2), ISFJ(3), ISFP(4),
    INTJ(5), INTP(6), INFJ(7), INFP(8),
    ESTJ(9), ESTP(10), ESFJ(11), ESFP(12),
    ENTJ(13), ENTP(14), ENFJ(15), ENFP(16);

    private int type;

    MBTIType(int type){
        this.type = type;
    }

    public int getType(int type){
        return type;
    }
}
