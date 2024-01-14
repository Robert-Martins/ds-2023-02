type SnackType = 'SUCCESS' | 'INFO' | 'ERROR';

export class Snack {

    message: string;
    type: SnackType;

    constructor(
        message: string,
        type: SnackType
    ) {
        this.message = message;
        this.type = type;
    }

    public equals(other: Snack): boolean {
        return this.message === other.message && this.type === other.type;
    }

}