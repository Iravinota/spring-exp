package com.ws.exp.spring.jk.reactive.redis;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Coffee
 *
 * @author Eric at 2020-02-26_22:13
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coffee {
    private Long id;
    private String name;
    private Long price;
}
