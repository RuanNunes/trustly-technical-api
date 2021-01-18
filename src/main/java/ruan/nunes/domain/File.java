package ruan.nunes.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class File {
    private String name;
    private String type;
    private int bytes;
    private int lines;
}
