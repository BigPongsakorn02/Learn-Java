// Custom exception for stack overflow
class StackFullException extends Exception {
    public StackFullException(String message) {
        super(message);
    }
}

// Custom exception for stack underflow
class StackEmptyException extends Exception {
    public StackEmptyException(String message) {
        super(message);
    }
}

class QueueFullException extends Exception {
    public QueueFullException(String message) {
        super(message);
    }
}

class QueueEmptyException extends Exception {
    public QueueEmptyException(String message) {
        super(message);
    }
}