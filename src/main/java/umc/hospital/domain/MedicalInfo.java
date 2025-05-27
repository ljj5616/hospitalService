package umc.hospital.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.hospital.domain.base.BaseEntity;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MedicalInfo extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer fee;

    @Column(nullable = false)
    private String prescription;

    @OneToOne(mappedBy = "medicalInfo")
    private Reservation reservation;
}
