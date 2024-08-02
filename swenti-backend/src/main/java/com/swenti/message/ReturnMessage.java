package com.swenti.message;

public enum ReturnMessage {
    SUCCESS("로그인 성공"),
    NOT_MATCH("입력하신 정보가 일치하지 않습니다."),
    DEL_COMMENT("댓글이 삭제 되었습니다.");

    private final String comment;

    ReturnMessage(String message) {
        this.comment = message;
    }

    public String getComment() {
        return comment;
    }
}
