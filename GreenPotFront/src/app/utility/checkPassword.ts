import {AbstractControl, ValidationErrors, ValidatorFn} from '@angular/forms';

export const samePasswordValidator: ValidatorFn = (control: AbstractControl): ValidationErrors | null => {
  const password = control.get('password');
  const password2 = control.get('password2');

  const error = { notMatched: true };
  const isValid = password?.value === password2?.value;
  if (!isValid) {
    password2?.setErrors(error);
  }
  return isValid ? null : error;
};
