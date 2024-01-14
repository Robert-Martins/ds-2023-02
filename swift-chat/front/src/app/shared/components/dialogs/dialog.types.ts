import { Type } from "@angular/core"

export type DialogComponentData = {
    component: Type<any>,
    inputs?: Record<string, unknown>
}

export type DialogOptions = {
    inputs?: Record<string, unknown>,
    onClose?: <T> (arg: T) => void
}