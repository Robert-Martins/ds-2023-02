import { Component, ElementRef, EventEmitter, Output, QueryList, ViewChildren } from '@angular/core';
import { AbstractControl, FormArray, FormBuilder, FormControl } from '@angular/forms';
import { isEnterKey, isArrowForward, isArrowKey, isArrowPrevious, isTabKey, isSpaceKey } from '../../../../core/utils/keyboard.utils';

@Component({
  selector: 'code-input',
  templateUrl: './code-input.component.html',
  styleUrl: './code-input.component.css'
})
export class CodeInputComponent {

  public code: FormArray = new FormArray([]);

  public readonly codeLength: number = 6;

  @ViewChildren('input')
  private inputs: QueryList<ElementRef>;

  @Output()
  public onSubmit: EventEmitter<string> = new EventEmitter<string>();

  constructor(
    private fb: FormBuilder
  ) {
    this.buildCodeForm();
  }

  public onChange($event: KeyboardEvent, index: number): void {
    this.handleKeyboardEvent($event.key, index);
  }

  public resolveControl(formControl: AbstractControl): FormControl {
    return formControl as FormControl;
  }

  private submit(): void {
    this.inputs.forEach(input => input.nativeElement.blur());
    const fullcode: string = this.code.controls
                          .map(control => control.value)
                          .join('');
    this.onSubmit.emit(fullcode);
  }

  private handleFocusChange(index: number, val: number): void {
    let newIndex = index + val;
    let codeLength = this.codeLength;
    if(newIndex >= codeLength)
      newIndex = 0;
    else if(newIndex < 0)
      newIndex = codeLength - 1;
    this.changeFocus(newIndex);
  }

  private changeFocus(index: number): void {
    const input: ElementRef = this.inputs.get(index);
    if(input)
      input.nativeElement.select();
  }

  private handleKeyboardEvent(key: string, index: number): void {
    if(this.isActionKey(key)) 
      this.onActionKeyPress(key, index);
    else if(isEnterKey(key))
      this.submit();
    else if(isSpaceKey(key))
      return;
    else 
      this.onValueChanges(index);
  }

  private onActionKeyPress(key: string, index: number): void {
    let indexSum = 0;
    if(isArrowForward(key) || isTabKey(key))
      indexSum = 1;
    else if(isArrowPrevious(key))
      indexSum = -1;
    this.handleFocusChange(index, indexSum);
  }

  private onValueChanges(index: number): void {
    const value = this.code.controls.at(index).value;
    let indexSum = value !== '' ? 1 : 0;
    if(index === this.codeLength - 1)
      this.submit();
    else 
      this.handleFocusChange(index, indexSum);
  }

  private buildCodeForm(): void {
    const controls: FormControl[] = new Array(this.codeLength).fill('').map(val => this.fb.control(val));
    this.code = this.fb.array(controls);
  }

  private isActionKey(key: string): boolean {
    return isArrowKey(key) || isTabKey(key);
  }

}
