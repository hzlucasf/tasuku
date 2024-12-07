package com.hzlucasf.tasuku.service;

import com.hzlucasf.tasuku.model.Task;
import com.hzlucasf.tasuku.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository repository;

    public Task save(Task task) {
        return repository.save(task);
    }

    public List<Task> findAll() {
        return repository.findAll();
    }

    public Optional<Task> findById(Integer id) {
        return repository.findById(id);
    }

    public Optional<Task> update(Integer id, Task sourceTask) {
        var optionalTargetTask = repository.findById(id);

        if (optionalTargetTask.isEmpty()) {
            return Optional.empty();
        }

        var targetTask = optionalTargetTask.get();

        targetTask.setName(sourceTask.getName());

        targetTask.setDescription(sourceTask.getDescription());

        targetTask.setFinished(sourceTask.getFinished());

        targetTask.setPriority(sourceTask.getPriority());

        return Optional.of(repository.save(targetTask));
    }

    public boolean delete(Integer id) {
        var optionalTask = repository.findById(id);

        if (optionalTask.isEmpty()) {
            return false;
        }

        repository.delete(optionalTask.get());

        return true;
    }
}
