package com.billshare.app.common.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Entity not found.")
class EntityNotFoundException: RuntimeException()