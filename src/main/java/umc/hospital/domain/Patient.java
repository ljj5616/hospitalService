package umc.hospital.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.hospital.domain.base.BaseEntity;
import umc.hospital.domain.enums.Gender;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Patient extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, length = 50)
    private String address;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    private Gender gender;

    @Column(nullable = false)
    private LocalDate dateOfBirth;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<Reservation> reservationList = new ArrayList<>();
}
