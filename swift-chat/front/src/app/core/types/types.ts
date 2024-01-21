export type Enum = {
    name: string;
    description: string;
}

export type ApplicationError = {
    error: any | SwiftApplicationError;
}

export type SwiftApplicationError = {
    title: string;
    status: number;
    detais: string;
    developerMessage: string;
    className: string;
    timestamp: Date;
}