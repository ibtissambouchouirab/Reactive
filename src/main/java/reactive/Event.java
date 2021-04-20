package reactive;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;


@Data
@AllArgsConstructor
public class Event {
    private  final long id;
    private  final Date when ;

    @Override
    public String toString() {
        return "Event [id=" + id + ", when=" + when +"]";
    }

}
