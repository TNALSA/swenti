package com.swenti.model;

import lombok.Data;

import java.io.Serializable;
@Data
class CommentPK implements Serializable {
    private int articleid;
    private int commentid;
}
