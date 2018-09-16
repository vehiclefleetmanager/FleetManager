package pl.domain.company.database.modelFx.vehicles.mark;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class MarkFx {
    private LongProperty id = new SimpleLongProperty();
    private StringProperty nameMark = new SimpleStringProperty();

    public long getId() {
        return id.get();
    }

    public LongProperty idProperty() {
        return id;
    }

    public void setId(long id) {
        this.id.set(id);
    }

    public String getNameMark() {
        return nameMark.get();
    }

    public StringProperty nameMarkProperty() {
        return nameMark;
    }

    public void setNameMark(String nameMark) {
        this.nameMark.set(nameMark);
    }

    @Override
    public String toString() {
        return nameMark.get();
    }
}
