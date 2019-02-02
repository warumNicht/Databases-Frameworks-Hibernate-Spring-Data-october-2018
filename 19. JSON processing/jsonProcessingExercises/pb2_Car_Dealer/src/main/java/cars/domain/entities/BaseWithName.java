package cars.domain.entities;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Objects;

@MappedSuperclass
public abstract class BaseWithName  extends BaseEntity{
    @Column(name = "name")
    private String name;

    public BaseWithName() {
    }

    public BaseWithName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
