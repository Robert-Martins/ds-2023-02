export class User {

    public id: string;
    public name: string;

    constructor(
        id: string = null,
        name: string = null
    ) {
        this.id = id;
        this.name = name;
    }

}