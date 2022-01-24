package SocketServer;

import java.io.Serializable;

public class BoardVO implements Serializable {

    private static final long serialVersionUID = 1234567890L;

    private int idx;

    private String title;
    private String content;
    private String writer;
    private String reason;

    public int getIdx(){return idx;}
    public void setIdx(int idx){this.idx = idx;}

    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}

    public String getWriter() {return writer;}
    public void setWriter(String writer) {this.writer = writer;}

    public String getReason() {return reason;}
    public void setReason(String reason) {this.reason = reason;}

    public String getContent() {return content;}
    public void setContent(String content) {this.content = content;}

    @Override
    public String toString(){
        return "BoardVO [idx="+idx+",title="+title+",content="+content+",writer="+writer+",reason="+reason+"]";
    }
}
