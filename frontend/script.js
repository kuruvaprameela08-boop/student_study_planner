let tasks = [];

const taskForm = document.getElementById("taskForm");

taskForm.addEventListener("submit", function(event) {

    event.preventDefault();

    const title = document.getElementById("title").value;
    const subject = document.getElementById("subject").value;
    const deadline = document.getElementById("deadline").value;
    const priority = document.getElementById("priority").value;

    const task = {

        id: Date.now(),

        title: title,

        subject: subject,

        deadline: deadline,

        priority: priority,

        completed: false
    };

    tasks.push(task);

    taskForm.reset();

    displayTasks();

});


function displayTasks() {

    const table = document.getElementById("taskTable");

    table.innerHTML = "";

    tasks.forEach(function(task) {

        const row = document.createElement("tr");

        if (task.completed) {
            row.classList.add("completed");
        }

        row.innerHTML = `

            <td>${task.title}</td>

            <td>${task.subject}</td>

            <td>${task.deadline}</td>

            <td>${task.priority}</td>

            <td>
                ${task.completed ? "Completed" : "Pending"}
            </td>

            <td>

                <button
                    class="complete"
                    onclick="completeTask(${task.id})">
                    Complete
                </button>

                <button
                    class="delete"
                    onclick="deleteTask(${task.id})">
                    Delete
                </button>

            </td>

        `;

        table.appendChild(row);

    });

    updateDashboard();
}


function completeTask(id) {

    const task = tasks.find(function(task) {

        return task.id === id;

    });

    if (task) {

        task.completed = true;

        displayTasks();

    }

}


function deleteTask(id) {

    tasks = tasks.filter(function(task) {

        return task.id !== id;

    });

    displayTasks();

}


function updateDashboard() {

    const total = tasks.length;

    const completed = tasks.filter(function(task) {

        return task.completed;

    }).length;

    const pending = total - completed;

    document.getElementById("totalTasks").textContent = total;

    document.getElementById("completedTasks").textContent = completed;

    document.getElementById("pendingTasks").textContent = pending;

}