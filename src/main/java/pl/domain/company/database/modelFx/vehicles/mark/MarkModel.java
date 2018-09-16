package pl.domain.company.database.modelFx.vehicles.mark;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.domain.company.database.dao.MarkDao;
import pl.domain.company.database.models.Mark;
import pl.domain.company.database.utils.converters.ConvertMark;
import pl.domain.company.database.utils.exceptions.ApplicationExceptions;

import java.util.List;
public class MarkModel {
    private ObjectProperty<MarkFx> mark =
            new SimpleObjectProperty<>(new MarkFx());
    private ObservableList<MarkFx> markList =
            FXCollections.observableArrayList();

    public void init() throws ApplicationExceptions {
        MarkDao markDao = new MarkDao();
        List<Mark> markList = markDao.queryForAll(Mark.class);
        initMarkList(markList);
    }

    private void initMarkList(List<Mark> markVehicles) {
        this.markList.clear();
        markVehicles.forEach(mark -> {
            MarkFx markFx = ConvertMark.convertToMarkFx(mark);
            this.markList.add(markFx);
        });
    }

    public void saveVehicleMarkInDatabase(String name) throws ApplicationExceptions {
        MarkDao markDao = new MarkDao();
        Mark markVehicle = new Mark();
        markVehicle.setMarkName(name);
        markDao.createOrUpdate(markVehicle);
        init();

    }


    public ObservableList<MarkFx> getMarkList() {
        return markList;
    }

    public void setMarkList(ObservableList<MarkFx> markList) {
        this.markList = markList;
    }

    public MarkFx getMark() {
        return mark.get();
    }

    public void setMark(MarkFx mark) {
        this.mark.set(mark);
    }

    public ObjectProperty<MarkFx> markProperty() {
        return mark;
    }
}
