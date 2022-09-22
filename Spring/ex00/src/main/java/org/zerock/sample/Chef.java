package org.zerock.sample;

import org.springframework.stereotype.Component;

import lombok.Data;

// 오랫동안 사용해야하는 애들은 Spring에 Bean으로 등록해야한다. 
@Component //객체를 만들어서 가지고 사용한다. ->root Context
@Data
public class Chef {

}
