package org.zerock.domain;

import lombok.Data;
import java.util.Date;

// InitBinder
// 피라미터 수집(바인딩) 파라미터를 변환해서 처리.

@Data
public class TodoDTO {

    private String title;
    private Date dueDate;
}
