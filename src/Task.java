public class Task {

    private int id;
    private String title;
    private String subject;
    private String deadline;
    private String priority;
    private boolean completed;

    public Task(int id, String title, String subject,
                String deadline, String priority) {

        this.id = id;
        this.title = title;
        this.subject = subject;
        this.deadline = deadline;
        this.priority = priority;
        this.completed = false;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSubject() {
        return subject;
    }

    public String getDeadline() {
        return deadline;
    }

    public String getPriority() {
        return priority;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void markCompleted() {
        completed = true;
    }

    public void displayTask() {

        System.out.println(
            id + " | " +
            title + " | " +
            subject + " | " +
            deadline + " | " +
            priority + " | " +
            (completed ? "Completed" : "Pending")
        );
    }
}