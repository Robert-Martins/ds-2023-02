import { Component, Input } from '@angular/core';
import { BehaviorSubject, Subject } from 'rxjs';
import { environment } from '../../../../../../environments/environment';

@Component({
  selector: 'swift-qrcode',
  templateUrl: './qrcode.component.html',
  styleUrl: './qrcode.component.css'
})
export class QrcodeComponent {

  public qrCode$: BehaviorSubject<string> = new BehaviorSubject(null);

  private readonly DEFAULT_QR_CODE_SIZE: string = 'size=320x320';

  private readonly DEFAULT_QR_CODE_COLORS: string = 'color=5F3DC4&bgcolor=000';

  @Input()
  public url$: BehaviorSubject<string> = new BehaviorSubject(null);

  public onClickClose(): void {
    this.qrCode$.next(null);
  }

  constructor() {
    this.url$.subscribe(this.setQrCodeUrl);
  }

  private setQrCodeUrl = (url: string): void => {
    this.qrCode$.next(this.buildQrCodeUrl(url));
  }

  private buildQrCodeUrl(url: string): string {
    return `${environment.qrCodeApi}?${this.DEFAULT_QR_CODE_SIZE}&${this.DEFAULT_QR_CODE_COLORS}&data=${url}`;
  }

}
