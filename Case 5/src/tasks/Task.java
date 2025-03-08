package tasks;

public class Task {

    private String task;
    private String stateTask;


    public Task(String task, String stateTask)
    {
        this.task = task;
        this.stateTask = stateTask;

    }

    public String getStateTask() {
        return stateTask;
    }

    @Override
    public String toString () {

        return task + " , " + stateTask ;

    }



}

