package app.jdbc;

import app.dto.StorageBalancesReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class JdbcTemplateExample {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcTemplateExample(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Object report(){
        return jdbcTemplate.query("select s.title as storage, article, p.title as title, unit, SUM(quantity) as quantity from operation left join item i on operation.id = i.operation_id\n" +
                "left join product p on i.product_id = p.id\n" +
                "left join storage s on operation.storage_id = s.id\n" +
                //"where s.title like 'central warehouse'" +
                "group by s.title, article, p.title, unit",  (rs, rowNum) -> {
            return StorageBalancesReport.builder()
                    .storage(rs.getString("storage"))
                    .article(rs.getString("article"))
                    .title(rs.getString("title"))
                    .unit(rs.getString("unit"))
                    .quantity(rs.getInt("quantity"))
                    .build();
        });
    }
}
