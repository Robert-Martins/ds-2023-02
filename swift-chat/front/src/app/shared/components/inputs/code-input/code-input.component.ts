import { Component, EventEmitter, Output, QueryList, ViewChildren } from '@angular/core';
import { FormArray, FormBuilder } from '@angular/forms';
import { isEnterKey, isArrowForward, isArrowKey, isArrowPrevious, isTabKey } from '../../../../core/utils/keyboard.utils';

@Component({
  selector: 'code-input',
  templateUrl: './code-input.component.html',
  styleUrl: './code-input.component.css'
})
export class CodeInputComponent {

  public code: FormArray = new FormArray([]);

  public readonly codeLength: number = 6;

  @ViewChildren('input')
  private inputs: QueryList<HTMLInputElement>;

  @Output()
  public onSubmit: EventEmitter<string> = new EventEmitter<string>();

  constructor(
    private fb: FormBuilder
  ) {
    this.buildCodeForm();
  }

  public onChange($event: KeyboardEvent, value: string, index: number): void {
    this.handleKeyboardEvent($event.key, value, index);
  }

  private submit(): void {
    this.onSubmit.emit(
      this.code.controls
        .map(control => control.value)
        .join('')
    );
  }

  private handleFocusChange(index: number, val: number): void {
    let newIndex = index + val;
    let codeLength = this.codeLength;
    if(newIndex > codeLength)
      newIndex = 0;
    else if(newIndex < codeLength)
      newIndex = codeLength;
    this.changeFocus(newIndex);
  }

  private changeFocus(index: number): void {
    const input: HTMLInputElement = this.inputs.get(index);
    if(input)
      input.focus();
  }

  private handleKeyboardEvent(key: string, value: string, index: number): void {
    if(this.isActionKey(key)) 
      this.onActionKeyPress(key, index);
    else if(isEnterKey(key))
      this.submit();
    else 
      this.onValueChanges(value, index);
  }

  private onActionKeyPress(key: string, index: number): void {
    let indexSum = 0;
    if(isArrowForward(key) || isTabKey(key))
      indexSum = 1;
    else if(isArrowPrevious(key))
      indexSum = -1;
    if(indexSum !== 0)
      this.handleFocusChange(index, indexSum);
  }

  private onValueChanges(value: string, index: number): void {
    let indexSum = value !== '' ? 1 : 0;
    if(index === this.codeLength)
      this.submit();
    else 
      this.handleFocusChange(index, indexSum);
  }

  private buildCodeForm(): void {
    this.code = this.fb.array(
      [
        new Array(this.codeLength).fill('')
      ]
    );
  }

  private isActionKey(key: string): boolean {
    return isArrowKey(key) || isTabKey(key);
  }

}
