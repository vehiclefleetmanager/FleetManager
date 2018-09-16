package pl.domain.company.database.modelFx.vehicles.mark;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.domain.company.database.dao.MarkDao;
import pl.domain.company.database.models.Mark;
import pl.domain.company.database.utils.converters.ConvertMark;
import pl.domain.company.database.utils.exceptions.ApplicationExceptions;

import java.util.ArrayList;
import java.util.List;

public class MarkListModel {
    private ObservableList<MarkFx> markFxObservableList =
            FXCollections.observableArrayList();
    private List<MarkFx> markFxList = new ArrayList<>();

    public void init() throws ApplicationExceptions {
        MarkDao markDao = new MarkDao();
        List<Mark> markVehicleList = markDao.queryForAll(Mark.class);
        markVehicleList.clear();
        markVehicleList.forEach(markVehicle -> {
            this.markFxList.add(ConvertMark.convertToMarkFx(markVehicle));
        });
        this.markFxObservableList.setAll(markFxList);
    }

    public ObservableList<MarkFx> getMarkFxObservableList() {
        return markFxObservableList;
    }
}
