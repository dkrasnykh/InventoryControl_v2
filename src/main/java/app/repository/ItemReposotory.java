package app.repository;

import app.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemReposotory extends JpaRepository<Item, Long> {
}
