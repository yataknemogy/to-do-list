import React, { useState, useEffect } from 'react';
import axios from 'axios';

export function App() {
    const [tasks, setTasks] = useState([]);

    useEffect(() => {
        fetchTasks();
    }, []);

    const fetchTasks = async () => {
        try {
            const response = await axios.get('/api/tasks');
            setTasks(response.data);
        } catch (error) {
            console.error('Error fetching tasks:', error);
        }
    };

    return (
        <div>
            <h1>Task Manager</h1>
            <ul>
                {tasks.map(task => (
                    <li key={task.id}>
                        {task.title} - {task.description}
                    </li>
                ))}
            </ul>
        </div>
    );
}