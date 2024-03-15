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
            <h1 style={{ textAlign: 'center', color: 'blue' }}>Task Manager</h1>
            <ul style={{ listStyleType: 'none', padding: 0 }}>
                {tasks.map(task => (
                    <li key={task.id} style={{ marginBottom: '10px', backgroundColor: '#f4f4f4', padding: '10px', borderRadius: '5px' }}>
                        <h3>{task.title}</h3>
                        <p>{task.description}</p>
                    </li>
                ))}
            </ul>
        </div>
    );
}
