import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';

@customElement('client-profile-view')
export class ClientProfileView extends LitElement {
  static get styles() {
    return css`
      :host {
          display: block;
          height: 100%;
      }
      `;
  }

  render() {
    return html`
<vaadin-vertical-layout style="width: 100%; height: 100%;" id="vaadinVerticalLayout">
 <h2 id="h2" style="padding: var(--lumo-space-s);">Perfil</h2>
 <div style="flex-grow: 1; align-self: flex-start; padding: var(--lumo-space-xs); flex-shrink: 1; height:auto;" id="div">
  <h3>Datos personales</h3>
  <br>
  <span id="span" style="padding: var(--lumo-space-s);"></span>
  <br>
  <span id="span1" style="padding: var(--lumo-space-s);"></span>
  <br>
  <span id="span2" style="padding: var(--lumo-space-s);"></span>
  <br>
  <span id="span3" style="padding: var(--lumo-space-s);"></span>
  <br>
 </div>
 <div style="align-self: stretch; padding: var(--lumo-space-xs);" id="div1">
  <h3>Cuentas Bancarias</h3>
 </div>
 <div style="width: 100%; height: 100%; padding: var(--lumo-space-xs);" id="div2">
  <h3>Tarjetas Asociadas</h3>
 </div>
</vaadin-vertical-layout>
`;
  }

  // Remove this method to render the contents of this view inside Shadow DOM
  createRenderRoot() {
    return this;
  }
}
