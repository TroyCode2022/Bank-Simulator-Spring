import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/grid/src/vaadin-grid.js';
import '@vaadin/button/src/vaadin-button.js';

@customElement('clients-view')
export class ClientsView extends LitElement {
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
<vaadin-vertical-layout style="width: 100%; height: 100%;margin-left:10px;" id="vaadinVerticalLayout">
 <h2 id="h2">Lista de Clientes:</h2>
 <vaadin-grid id="vaadinGrid" is-attached multi-sort-priority="prepend"></vaadin-grid>
 <vaadin-button id="vaadinButton" style="align-self: flex-end;" tabindex="0"></vaadin-button>
</vaadin-vertical-layout>
`;
  }

  // Remove this method to render the contents of this view inside Shadow DOM
  createRenderRoot() {
    return this;
  }
}
