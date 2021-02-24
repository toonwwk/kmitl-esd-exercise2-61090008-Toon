package kmitl.esd.exercise2;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Getter @Setter
public class CustomerDTO implements Serializable {
    private Long id;
    private String name;
    private Long age;
    private String remark;

    public CustomerDTO() {}

    public CustomerDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public CustomerDTO(Long id, String name, Long age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age  +
                '}';
    }
}
