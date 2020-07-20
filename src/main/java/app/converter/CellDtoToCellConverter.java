package app.converter;

import app.dto.CellDto;
import app.entity.Cell;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CellDtoToCellConverter implements Converter<CellDto, Cell> {
    @Override
    public Cell convert(CellDto cellDto) {
        Cell target = new Cell();

        String section = cellDto.getSection();
        String line = cellDto.getLine();
        String rack = cellDto.getRack();
        String tier = cellDto.getTier();
        String position = cellDto.getPosition();

        target.setSection(section);
        target.setLine(line);
        target.setRack(rack);
        target.setTier(tier);
        target.setPosition(position);
        target.setTitle(section+"-"+line+"-"+rack+"-"+tier+"-"+position);
        target.setId(cellDto.getId());
        target.setCellType(cellDto.getCellType());

        return target;
    }
}
