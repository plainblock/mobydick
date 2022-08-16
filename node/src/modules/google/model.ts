import {Book, BookStatus, ISBN} from "../hooks/model";

export interface GoogleBook {
  kind: string,
  totalItems: number,
  items: GoogleBookItem[],
}

export interface GoogleBookItem {
  id: string,
  kind: string,
  etag: string,
  selfLink: string,
  volumeInfo: VolumeInfo,
  saleInfo: SaleInfo,
  accessInfo: AccessInfo,
  searchInfo: SearchInfo,
}

export function toBook(item: GoogleBookItem): Book {
  return {
    id: "",
    isbn: new ISBN(getISBN(item.volumeInfo)),
    title: item.volumeInfo.title,
    author: getAuthor(item.volumeInfo),
    publisher: item.volumeInfo.publisher,
    publishedDate: item.volumeInfo.publishedDate,
    information: item.volumeInfo.previewLink,
    status: new BookStatus(0),
    registerAt: "",
    readAt: "",
  }
}

interface VolumeInfo {
  title: string,
  subtitle: string,
  authors: string[],
  publisher: string,
  publishedDate: string,
  description: string,
  industryIdentifiers: IndustryIdentifier[],
  pageCount: number,
  dimensions: Dimension,
  readingModes: ReadingMode,
  printType: string,
  categories: string[],
  averageRating: number,
  ratingsCount: number,
  maturityRating: string,
  allowAnonLogging: boolean,
  contentVersion: string,
  imageLinks: ImageLink,
  language: string,
  mainCategory: string,
  previewLink: string,
  infoLink: string,
  canonicalVolumeLink: string,
}

function getAuthor(volumeInfo: VolumeInfo): string {
  if (!volumeInfo.authors) {
    return "";
  }
  return volumeInfo.authors.join(", ");
}

function getISBN(volumeInfo: VolumeInfo): string {
  if (!volumeInfo.industryIdentifiers) {
    return "";
  }
  let isbn13 = "";
  let isbn10 = "";
  volumeInfo.industryIdentifiers.forEach((value: IndustryIdentifier) => {
    if (value.type === "ISBN_13") {
      isbn13 = value.identifier;
    } else if (value.type === "ISBN_10") {
      isbn10 = value.identifier
    }
  });
  if (isbn13) {
    return isbn13;
  }
  return isbn10;
}

interface IndustryIdentifier {
  type: string,
  identifier: string,
}

interface Dimension {
  height: string,
  width: string,
  thickness: string,
}

interface ReadingMode {
  text: boolean,
  image: boolean,
}

interface ImageLink {
  thumbnail: string,
  small: string,
  medium: string,
  large: string,
  smallThumbnail: string,
  extraLarge: string,
}

interface SaleInfo {
  country: string,
  saleability: string,
  isEbook: boolean,
  listPrice: SalePrice,
  retailPrice: SalePrice,
  buyLink: string,
  onSaleDate: string,
}

interface SalePrice {
  amount: boolean;
  currencyCode: string;
}

interface AccessInfo {
  country: string,
  viewability: string,
  embeddable: boolean,
  publicDomain: boolean,
  textToSpeechPermission: string,
  epub: AccessLink,
  pdf: AccessLink,
  webReaderLink: string,
  accessViewStatus: string,
  quoteSharingAllowed: boolean,
  downloadAccess: DownloadAccess,
}

interface AccessLink {
  downloadLink: string,
  acsTokenLink: string,
  isAvailable: boolean,
}

interface DownloadAccess {
  kind: string,
  volumeId: string,
  restricted: boolean,
  deviceAllowed: boolean,
  justAcquired: boolean,
  maxDownloadDevices: number,
  downloadsAcquired: number,
  nonce: string,
  source: string,
  reasonCode: string,
  message: string,
  signature: string,
}

interface SearchInfo {
  textSnippet: string,
}
