package com.example.demo.application.login.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class PrincipalDto {

    private String username;
    private Boolean isEnabled;

    /**
     * コンストラクター.
     *
     * @param username ユーザー名
     * @param isEnabled 有効かどうか
     */
    public PrincipalDto(
            String username,
            Boolean isEnabled) {
        this.username = username;
        this.isEnabled = isEnabled;
    }
}
