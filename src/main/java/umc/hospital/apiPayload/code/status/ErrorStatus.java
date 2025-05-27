package umc.hospital.apiPayload.code.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import umc.hospital.apiPayload.code.BaseErrorCode;
import umc.hospital.apiPayload.code.ErrorReasonDTO;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {

    // 가장 일반적인 응답
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "서버 에러, 관리자에게 문의 바랍니다."),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST,"COMMON400","잘못된 요청입니다."),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED,"COMMON401","인증이 필요합니다."),
    _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON403", "금지된 요청입니다."),

    // 환자 관련 에러
    PATIENT_NOT_FOUND(HttpStatus.BAD_REQUEST, "PATIENT4001", "환자가 없습니다."),
    PATIENT_DUPLICATED(HttpStatus.CONFLICT, "PATIENT4002", "이미 등록된 환자입니다."),

    // 의사 관련 에러
    DOCTOR_NOT_FOUND(HttpStatus.BAD_REQUEST, "DOCTOR4001", "의사가 없습니다."),
    DOCTOR_DUPLICATED(HttpStatus.CONFLICT, "DOCTOR4002", "이미 등록된 의사입니다."),

    // 병원 관련 에러
    HOSPITAL_NOT_FOUND(HttpStatus.BAD_REQUEST, "HOSPITAL4001", "병원이 없습니다."),
    HOSPITAL_DUPLICATED(HttpStatus.CONFLICT, "HOSPITAL4002", "이미 등록된 병원입니다."),

    // 예약 관련 에러
    RESERVATION_NOT_FOUND(HttpStatus.BAD_REQUEST, "RESERVATION4001", "예약이 없습니다."),
    RESERVATION_CONFLICT(HttpStatus.CONFLICT, "RESERVATION4002", "해당 시간에 이미 예약이 존재합니다."),
    RESERVATION_INVALID_STATUS(HttpStatus.BAD_REQUEST, "RESERVATION4003", "유효하지 않은 예약 상태입니다."),
    RESERVATION_ALREADY_COMPLETED(HttpStatus.BAD_REQUEST, "RESERVATION4004", "이미 완료된 예약입니다."),

    // 진료과 관련 에러
    DEPARTMENT_NOT_FOUND(HttpStatus.BAD_REQUEST, "DEPARTMENT4001", "진료과가 없습니다."),

    // 진료정보 관련 에러
    MEDICAL_INFO_NOT_FOUND(HttpStatus.BAD_REQUEST, "MEDICAL4001", "진료 정보가 없습니다."),
    MEDICAL_INFO_ALREADY_REGISTERED(HttpStatus.CONFLICT, "MEDICAL4002", "이미 진료 정보가 등록되어 있습니다.");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ErrorReasonDTO getReason() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .build();
    }

    @Override
    public ErrorReasonDTO getReasonHttpStatus() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .httpStatus(httpStatus)
                .build();
    }
}
