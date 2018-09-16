package pl.domain.company.database.utils.converters;

import pl.domain.company.database.modelFx.vehicles.mark.MarkFx;
import pl.domain.company.database.models.Mark;

public class ConvertMark {
    public static Mark convertToMark(MarkFx markFx){
        Mark markVehicle = new Mark();
        markVehicle.setId(markFx.getId());
        markVehicle.setMarkName(markFx.getNameMark());
        return markVehicle;
    }

    public static MarkFx convertToMarkFx(Mark markVehicle){
        MarkFx markFx = new MarkFx();
        markFx.setId(markVehicle.getId());
        markFx.setNameMark(markVehicle.getMarkName());
        return markFx;
    }
}
