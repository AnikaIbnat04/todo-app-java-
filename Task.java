package TODOY_APP;

public class Task {
        String description;
        boolean isDone;

        public Task(String description) {
            this.description = description;
            this.isDone = false;
        }

        public String toString() {
            if (isDone) {
                return "[x] " + description;
            } else {
                return "[ ] " + description;
            }
        }
}
