public class Solution {
    public static void main(String[] args) {
        SMSLogger logger = new SMSLogger(Level.ERROR);
        logger.writeMessage("info", Level.INFO);
        logger.writeMessage("debug", Level.DEBUG);
        logger.writeMessage("error", Level.ERROR);
    }
}

class Level {
    static final int ERROR = 1;
    static final int DEBUG = 2;
    static final int INFO = 3;
}

interface Logger {
    void writeMessage(String message, int level);
}

class SMSLogger implements Logger {

    private int priority;

    SMSLogger(int priority) {
        this.priority = priority;
    }

    private Logger next;

    public void setNext(Logger next) {
        this.next = next;
    }

    @Override
    public void writeMessage(String message, int level) {
        if (level <= priority) {
            System.out.println("SMS: " + message);
        }
        if (next != null) {
            next.writeMessage(message, level);
        }
    }
}



