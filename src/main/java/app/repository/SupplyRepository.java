package app.repository;

import app.entity.Supply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SupplyRepository extends JpaRepository<Supply, Long> {
    Supply findFirstByInvoiceDateAndInvoiceNumber(LocalDate invoiceDate, String invoiceNumber);
}
