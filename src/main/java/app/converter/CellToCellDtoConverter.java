package app.converter;

import app.dto.CellDto;
import app.entity.Cell;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CellToCellDtoConverter implements Converter<Cell, CellDto> {
    @Override
    public CellDto convert(Cell cell) {
        CellDto target = new CellDto();
        target.setSection(cell.getSection());
        target.setLine(cell.getLine());
        target.setRack(cell.getRack());
        target.setTier(cell.getTier());
        target.setPosition(cell.getPosition());
        target.setTitle(cell.getTitle());
        target.setCellType(cell.getCellType());
        target.setId(cell.getId());
        return target;
    }
}
