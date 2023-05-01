package com.istad.istadresfulapi.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class FileResponse {
    String ImageName;
    String message;
}
