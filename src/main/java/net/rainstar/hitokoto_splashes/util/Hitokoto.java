package net.rainstar.hitokoto_splashes.util;

public class Hitokoto {

    private int id;
    private String uuid;
    private String hitokoto;
    private String type;
    private String from;
    private String from_who;
    private String creator;
    private int creator_uid;
    private int reviewer;
    private String commit_from;
    private String created_at;
    private int length;
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    public String getUuid() {
        return uuid;
    }

    public void setHitokoto(String hitokoto) {
        this.hitokoto = hitokoto;
    }
    public String getHitokoto() {
        return hitokoto;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getType() {
        return type;
    }

    public void setFrom(String from) {
        this.from = from;
    }
    public String getFrom() {
        return from;
    }

    public void setFrom_who(String from_who) {
        this.from_who = from_who;
    }
    public String getFrom_who() {
        return from_who;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }
    public String getCreator() {
        return creator;
    }

    public void setCreator_uid(int creator_uid) {
        this.creator_uid = creator_uid;
    }
    public int getCreator_uid() {
        return creator_uid;
    }

    public void setReviewer(int reviewer) {
        this.reviewer = reviewer;
    }
    public int getReviewer() {
        return reviewer;
    }

    public void setCommit_from(String commit_from) {
        this.commit_from = commit_from;
    }
    public String getCommit_from() {
        return commit_from;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
    public String getCreated_at() {
        return created_at;
    }

    public void setLength(int length) {
        this.length = length;
    }
    public int getLength() {
        return length;
    }

}


