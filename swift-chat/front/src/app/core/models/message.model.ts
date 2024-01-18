import { User } from './user.model';

export class Message {
  public id: string;
  public message: string;
  public author: User;

  //Adicionar Tempo
  public time: Date;


  constructor(id: string = null, message: string = null, author: User = null) {
    this.id = id;
    this.message = message;
    this.author = author;
  }
}
