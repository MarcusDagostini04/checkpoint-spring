package br.com.checkpoint.checkpointspring.repository;

import br.com.checkpoint.checkpointspring.model.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    Page<Task> findAllByIsActiveTrue(Pageable pageable);

}
