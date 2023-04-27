package com.istad.istadresfulapi.mapper;


import com.istad.istadresfulapi.model.Account;
import com.istad.istadresfulapi.model.response.AccountResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AutoAccountMapper {
    List<AccountResponse> mapToAccountResponse(List<Account>accounts);
    List<Account>mapToAccount(List<AccountResponse>responses);
}
