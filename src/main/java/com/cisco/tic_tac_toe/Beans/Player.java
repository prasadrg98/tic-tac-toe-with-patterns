package com.cisco.tic_tac_toe.Beans;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Player {
    String name;
    char symbol;
}
