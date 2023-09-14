package com.project.insert.domain.user;

import com.project.insert.domain.user.entity.authority.Authority;
import leehj050211.bsmOauth.dto.response.BsmResourceResponse;
import lombok.*;
import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class User {
    @Id @GeneratedValue
    private Long id;

    @Column(unique = true, length = 32)
    private String email;

    @Column(length = 16)
    private String nickname;

    @Enumerated(EnumType.STRING)
    @Column(length = 16)
    private Authority authority;

    public User update(BsmResourceResponse resource) {
        this.email = resource.getEmail();
        this.nickname = resource.getNickname();
        return this;
    }
}
